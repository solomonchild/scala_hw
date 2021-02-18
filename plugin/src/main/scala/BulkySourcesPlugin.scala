import sbt.{Def, _}
import sbt.Keys._

object BulkySourcesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val bulkySources = taskKey[Seq[(Int, String)]]("upload a config file from project to server")
    val bulkyThresholdInLines = SettingKey[Int]("bulky-threshold-in-lines")
  }

  import autoImport._

  def process(files: Seq[File], thr: Int): Seq[(Int, String)] = {
    files.map(f => (IO.readLines(f).length, f.absolutePath)).filter { case (l, n) => l > thr }.sortBy(_._1)(Ordering[Int].reverse)
  }

  override def globalSettings: Seq[Def.Setting[_]] = Seq(
    bulkyThresholdInLines := 100
  )

  override def projectSettings: Seq[Setting[_]] = Seq(
    Compile / bulkySources := process((Compile / sources).value, bulkyThresholdInLines.value),
    Test / bulkySources := process((Test / sources).value, bulkyThresholdInLines.value)
  )
}
