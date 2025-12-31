Schedule = Schedule(cron = "* 0 2 * * * *", timezone = "GMT", emails = ["email@gmail.com"], enabled = False)
SensorSchedule = SensorSchedule(enabled = False)

with DAG(Schedule = Schedule, SensorSchedule = SensorSchedule):
    awefesfsc__CountRecords_2 = Task(
        task_id = "awefesfsc__CountRecords_2", 
        component = "Model", 
        modelName = "awefesfsc__CountRecords_2"
    )
