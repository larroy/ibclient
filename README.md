# Scala IBClient

Interactive brokers Scala client.

This code wraps the java IBClient in asynchronous (futures) and reactive (RxScala) API.

All the wrapped functions from the java client return Futures, making the scala IBClient a
standalone class that plays nicely with concurrent code.


The Java IBClient is copyright interactive brokers and subject to it's license, see https://www.interactivebrokers.com/en/index.php?f=5041 and http://interactivebrokers.github.io/


## Examples

```
ibclient.marketData(new FutureContract("BZ", "20150316", "NYMEX"))
val  h = Await.result(ibclient.historicalData(new StockContract("SPY"), endDate, 20,
DurationUnit.DAY, BarSize._15_mins, WhatToShow.MIDPOINT, false),  Duration.Inf)
```

val res2 = Await.result(ibclient.historicalData(new CashContract("EUR","EUR.USD"), endDate2, 120, DurationUnit.SECOND, BarSize._1_min, WhatToShow.MIDPOINT, false), scala.concurrent.duration.Duration.Inf)
scala> import java.text.SimpleDateFormat
import java.text.SimpleDateFormat

    import java.util.Date
    import com.larroy.ibclient.contract.{CashContract, StockContract}
    import com.ib.client.Types.{BarSize, DurationUnit, WhatToShow, SecType}
    import scala.concurrent.duration._
    import scala.concurrent.Await
    import com.larroy.ibclient._
    import com.typesafe.config.ConfigFactory
    val cfg = ConfigFactory.load().getConfig("ibclient.test")
    val ibclient = new IBClient(cfg.getString("tws.host"), cfg.getInt("tws.port"), cfg.getInt("tws.clientId"))
    Await.result(ibclient.connect(), Duration.Inf)

 val subscription = ibclient.realtimeBars(new CashContract("EUR","EUR.USD"), WhatToShow.MIDPOINT)
 subscription.observableBar.subscribe({bar=>println(s"got bar ${bar}")}, {error ⇒ throw (error)})


 java -cp "target/scala-2.11/ibclient-assembly-0.1.jar":jython-standalone-2.7-b4.jar
 org.python.util.jython




import scala.concurrent.duration._
import org.joda.time._

val startDate = new DateTime(2015, 4, 10, 15, 0).toDate

val endDate = new DateTime(2015, 4, 13, 15, 0).toDate


val contract = new CashContract("EUR","EUR.USD")


val h = Await.result(ibclient.easyHistoricalData(contract, startDate, endDate, BarSize._1_min, WhatToShow.TRADES), duration.Duration.Inf)



Future contract identified by expiry date 2015

history -c CL -t FUT -e NYMEX -x USD  -y 20150421 -a "20150128 15:00:00" -z "20150415 15:00:00"  -b
_1_min -o cl.csv 



history -c VIX -e CBOE -t IND -a "20161001 00:00:00" -o vix.csv -b _1_day


java -jar target/scala-2.11/ibclient-assembly-0.2.2-SNAPSHOT.jar history -c VIX -e CBOE -t IND -a
"20161115 00:00:00" -z "201118 00:00:00" -o vix.csv -b _1_day



```
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import com.larroy.ibclient.contract.{CashContract, FutureContract, GenericContract, StockContract}
import com.larroy.ibclient.{IBClient}
val ibc = new IBClient("localhost", 7496, 3)
Await.result(ibc.connect(), Duration.Inf)
val c = new FutureContract("CL", "", "NYMEX")
val cd = Await.result(ibc.contractDetails(c), Duration.Inf)
```
