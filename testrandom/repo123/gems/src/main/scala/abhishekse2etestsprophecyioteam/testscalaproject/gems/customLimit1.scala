package abhishekse2etestsprophecyioteam.testscalaproject.gems


class Limit extends ComponentSpec {

  val name: String = "limitest"
  val category: String = "customisda2"
  val gemDescription: String = "Limits the number of rows in the input data"
  val docUrl: String = "https://docs.prophecy.io/low-code-spark/gems/transform/limit/"

  type PropertiesType = LimitProperties
  override def optimizeCode: Boolean = true

  case class LimitProperties(
                              @Property("Limit", "Number of rows to limit the incoming DataFrame to")
                              limit: SInt = SInt("10")
                            ) extends ComponentProperties

  implicit val limitPropertiesFormat: Format[LimitProperties] = Json.format

  def dialog: Dialog = Dialog("Limit")
    .addElement(
      ColumnsLayout(gap = Some("1rem"), height = Some("100%"))
        .addColumn(Ports(), "content")
        .addColumn(
          ExpressionBox("Limit")
            .bindProperty("limit")
            .bindPlaceholder("10")
            .withFrontEndLanguage,
          "5fr"
        )
    )

  def validate(component: Component)(implicit context: WorkflowContext): List[Diagnostic] = {
    import scala.collection.mutable.ListBuffer

    val diagnostics = ListBuffer[Diagnostic]()

    val (diag, limit) = (component.properties.limit.diagnostics, component.properties.limit.value)
    diagnostics ++= diag

    val limitDiagMsg = "Limit has to be an integer between [0, (2**31)-1]"
    if (limit.isDefined) {
      if (limit.get < 0)
        diagnostics += Diagnostic("properties.limit", limitDiagMsg, SeverityLevel.Error)
    }
    diagnostics.toList
  }

  def onChange(oldState: Component, newState: Component)(implicit context: WorkflowContext): Component = newState

  override def deserializeProperty(props: String): PropertiesType = Json.parse(props).as[PropertiesType]

  override def serializeProperty(props: PropertiesType): String = Json.stringify(Json.toJson(props))
  class LimitCode(props: PropertiesType) extends ComponentCode {

    def apply(spark: SparkSession, in: DataFrame): DataFrame = {
      val out = in.limit(props.limit)
      out
    }

  }
}
