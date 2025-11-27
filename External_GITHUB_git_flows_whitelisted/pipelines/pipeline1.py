Schedule = Schedule(cron = "* 0 2 * * * *", timezone = "GMT", emails = ["email@gmail.com"], enabled = False)
SensorSchedule = SensorSchedule(enabled = False)

with DAG(Schedule = Schedule, SensorSchedule = SensorSchedule):
    pipeline1__CountRecords_1 = Task(
        task_id = "pipeline1__CountRecords_1", 
        component = "Model", 
        modelName = "pipeline1__CountRecords_1"
    )
