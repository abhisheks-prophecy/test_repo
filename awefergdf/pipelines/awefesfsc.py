Schedule = Schedule(cron = "* 0 2 * * * *", timezone = "GMT", emails = ["email@gmail.com"], enabled = False)
SensorSchedule = SensorSchedule(enabled = False)

with DAG(Schedule = Schedule, SensorSchedule = SensorSchedule):
    awefesfsc__Pivot_1 = Task(task_id = "awefesfsc__Pivot_1", component = "Model", modelName = "awefesfsc__Pivot_1")
