from behave import given, when, then
from selenium import webdriver
from selenium.webdriver.common.by import By

BASE_URL = "https://the-internet.herokuapp.com/login"


@given("the application is running")
def step_impl(context):
    # Initialize the driver if not already done
    if not hasattr(context, 'driver'):
        options = webdriver.ChromeOptions()
        options.add_argument("--maximize-window")
        context.driver = webdriver.Chrome(options=options)
        context.driver.implicitly_wait(5)

@given("the test database is already seeded with users")
def step_impl(context):
    # For a UI demo, we assume the environment is ready
    pass

@given("the user is on the login page")
def step_impl(context):
    context.driver.get(BASE_URL)

@when('the user enters username "{username}"')
def step_impl(context, username):
    context.driver.find_element(By.ID, "username").send_keys(username)

@when('the user enters password "{password}"')
def step_impl(context, password):
    context.driver.find_element(By.ID, "password").send_keys(password)

@when("the user clicks the login button")
def step_impl(context):
    context.driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

@then("the user should be redirected to the secure area")
def step_impl(context):
    assert "/secure" in context.driver.current_url

@then('the the page should display a message containing "{message}"')
def step_impl(context, message):
    flash_message = context.driver.find_element(By.ID, "flash").text
    assert message in flash_message