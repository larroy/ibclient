package com.larroy.trabot.ib.handler

import com.larroy.trabot.ib.Bar

import scala.collection.mutable
/**
 * @author piotr 20.02.15
 */
case class HistoricalDataHandler(queue: mutable.Queue[Bar] = mutable.Queue.empty[Bar]) extends Handler
