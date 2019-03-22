package org.icar.h.sps_management.worker

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import org.icar.h.Akka2Jade

object SPSPlanValidator {
   def props(bridge : Akka2Jade, worker_sps : ActorRef) : Props = Props(classOf[SPSPlanValidator],bridge,worker_sps)
}

class SPSPlanValidator(val bridge : Akka2Jade, worker_sps : ActorRef) extends Actor with ActorLogging {

  override def preStart : Unit = {
      log.info("ready")
    }
    
    override def receive: Receive = {
      case Validate( plan ) =>
        log.info("i'm the validator, now contacting the sps reconfigurator for obtaining the solution: "+plan)
        worker_sps ! GetPlan(plan)

      case Plan(plan_ref,plan) =>
        Thread.sleep(2000)

        log.info("Validator: executing Matlab script with the solution "+plan_ref)
        // HERE THE CODE TO VALIDATE


        // IF THE PLAN IS CORRECT THEN...
        bridge.sendHead("validated("+plan_ref+")")

      case _ =>
        log.error("unspecified message")
    }
}