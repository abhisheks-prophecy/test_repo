package abhishekse2etestsprophecyioteam.testscalaproject.gems

import io.prophecy.gems._
import io.prophecy.gems.dataTypes._
import io.prophecy.gems.uiSpec._
import io.prophecy.gems.diagnostics._
import io.prophecy.gems.componentSpec._
import org.apache.spark.sql.{DataFrame, SparkSession}
import io.prophecy.gems.copilot._
import play.api.libs.json.{Format, OFormat, JsResult, JsValue, Json}


class MyNewReformat extends ComponentSpec {

  val name: String = "MyNewReformat"
  val category: String = "Transform"
  type PropertiesType = MyNewReformatProperties
  override def optimizeCode: Boolean = true

  case class MyNewReformatProperties(
    @Property("Property1")
    property1: String = ""
  ) extends ComponentProperties

  implicit val MyNewReformatPropertiesFormat: Format[MyNewReformatProperties] = Json.format

  def dialog: Dialog = Dialog("MyNewReformat")

  def validate(component: Component)(implicit context: WorkflowContext): List[Diagnostic] = Nil

  def onChange(oldState: Component, newState: Component)(implicit context: WorkflowContext): Component = newState

  def deserializeProperty(props: String): MyNewReformatProperties = Json.parse(props).as[MyNewReformatProperties]

  def serializeProperty(props: MyNewReformatProperties): String = Json.toJson(props).toString()

  class MyNewReformatCode(props: PropertiesType) extends ComponentCode {
    def apply(spark: SparkSession, in: DataFrame): DataFrame = {
      val out = in
      out
    }
  }
}
