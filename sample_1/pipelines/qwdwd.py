Schedule = Schedule(cron = "* 0 2 * * * *", timezone = "GMT", emails = ["email@gmail.com"], enabled = False)
SensorSchedule = SensorSchedule(enabled = False)

with DAG(Schedule = Schedule, SensorSchedule = SensorSchedule):
    qwdwd__CountRecords_1 = Task(
        task_id = "qwdwd__CountRecords_1", 
        component = "Model", 
        modelName = "qwdwd__CountRecords_1"
    )
