def before_all(context):
    print("Starting registration test suite...")


def before_scenario(context, scenario):
    print(f"Running: {scenario.name}")


def after_scenario(context, scenario):
    if scenario.status == 'failed':
        print(f"FAILED: {scenario.name}")


def after_all(context):
    print("Registration test suite completed.")
