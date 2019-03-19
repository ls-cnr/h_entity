package org.icar.h.sps_management.worker

import scala.collection.mutable.HashMap
import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import org.icar.h.Akka2Jade;

object SPSPlanGenerator {
   def props(bridge : Akka2Jade) : Props = Props(classOf[SPSPlanGenerator],bridge)
}

class SPSPlanGenerator(val bridge : Akka2Jade) extends Actor with ActorLogging {
   val discovered_solutions: HashMap[String, String] = HashMap.empty[String,String]

  override def preStart : Unit = {
      log.info("ready")
    }

    override def receive: Receive = {

      case FindSolutions(failure) =>
        Thread.sleep(2000)    //find a solution
        log.info("i'm the sps reconfigurator, finding solution for the failures: "+ failure +"\n")
        discovered_solutions += ("solution1" -> "cap1_cap2_cap3")
        bridge.sendHead("discovered(solution1)")

      case GetSolution(sol_ref) =>
        val sol : String = discovered_solutions(sol_ref)
        log.info("sending back the requested solution!")
        sender() ! Solution(sol_ref,sol)

      case _ ⇒
        println("PlanGen: unspecied message")
    }
}

