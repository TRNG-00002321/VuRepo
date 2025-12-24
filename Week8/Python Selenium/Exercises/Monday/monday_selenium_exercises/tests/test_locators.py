"""
Locator Strategy Mastery Tests

Demonstrate all 8 locator strategies and compare their usage.
"""

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import pytest


@pytest.fixture
def driver():
    """Create a Chrome driver for testing."""
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)
    driver.implicitly_wait(10)
    driver.get("https://the-internet.herokuapp.com/login")
    yield driver
    driver.quit()


class TestLocatorStrategies:
    """
    Test all 8 locator strategies on the login page.

    Page Elements to locate:
    - Username input: <input type="text" name="username" id="username">
    - Password input: <input type="password" name="password" id="password">
    - Login button: <button type="submit" class="radius">Login</button>
    - Page heading: <h2>Login Page</h2>
    - Subheading link: <a href="...">Elemental Selenium</a>
    """

    def test_locate_by_id(self, driver):
        """Locate elements by ID attribute."""
        # TODO: Locate username field by ID
        username = driver.find_element(By.ID, "username")
        assert username.is_displayed()

        # TODO: Locate password field by ID
        # YOUR CODE HERE
        password = driver.find_element(By.ID, "password")
        assert password.is_displayed()

    def test_locate_by_name(self, driver):
        """Locate elements by name attribute."""
        # TODO: Locate username field by name
        # YOUR CODE HERE
        username = driver.find_element(By.NAME, "username")
        assert username.is_displayed()

    def test_locate_by_class_name(self, driver):
        """Locate elements by class name."""
        # TODO: Locate the login button by class name "radius"
        # YOUR CODE HERE
        login_button = driver.find_element(By.CLASS_NAME, "radius")
        assert login_button.is_displayed()

    def test_locate_by_tag_name(self, driver):
        """Locate elements by tag name."""
        # TODO: Find all input elements on the page
        # YOUR CODE HERE
        inputs = driver.find_elements(By.TAG_NAME, "input")
        # Assert there are at least 2 inputs (username, password)
        assert len(inputs) >= 2

    def test_locate_by_link_text(self, driver):
        """Locate anchor elements by exact link text."""
        # TODO: Locate the "Elemental Selenium" link by exact text
        # YOUR CODE HERE
        link = driver.find_element(By.LINK_TEXT, "Elemental Selenium")
        assert link.is_displayed()
        assert link.text == "Elemental Selenium"

    def test_locate_by_partial_link_text(self, driver):
        """Locate anchor elements by partial link text."""
        # TODO: Locate the link using partial text "Elemental"
        # YOUR CODE HERE
        link = driver.find_element(By.PARTIAL_LINK_TEXT, "Elemental")
        assert link.is_displayed()
        assert link.text == "Elemental Selenium"

    def test_locate_by_css_selector(self, driver):
        """Locate elements by CSS selector."""
        # TODO: Implement CSS selector examples

        # Basic: Element by ID
        username_by_id = driver.find_element(By.CSS_SELECTOR, "#username")

        # Basic: Element by class
        button_by_class = driver.find_element(By.CSS_SELECTOR, ".radius")

        # Compound: Element with multiple attributes
        # YOUR CODE HERE

        # Child selector: form > input
        # YOUR CODE HERE

        # Attribute selector: input[type='password']
        # YOUR CODE HERE
        pass

    def test_locate_by_xpath(self, driver):
        """Locate elements by XPath."""
        # TODO: Implement XPath examples

        # Basic: By ID
        username_xpath = driver.find_element(By.XPATH, "//input[@id='username']")

        # Text content: Find heading by text
        heading = driver.find_element(By.XPATH, "//h2[text()='Login Page']")

        # Contains function: Find element with partial text
        # YOUR CODE HERE

        # Following sibling: Find password after username
        # YOUR CODE HERE

        # Parent axis: Find form containing username
        # YOUR CODE HERE
        pass


class TestXPathAdvanced:
    """Advanced XPath exercises."""

    def test_xpath_contains(self, driver):
        """
        Use contains() for partial attribute matching.
        Find elements where attribute contains specific text.
        """
        # Find button that contains "Login" text
        # YOUR CODE HERE
        pass

    def test_xpath_starts_with(self, driver):
        """
        Use starts-with() for prefix matching.
        Useful for dynamic IDs like "user_12345".
        """
        # Example: //input[starts-with(@id, 'user')]
        # YOUR CODE HERE
        pass

    def test_xpath_text_functions(self, driver):
        """
        Use text(), normalize-space() for text matching.
        """
        # Find heading with exact text
        heading = driver.find_element(By.XPATH, "//h2[text()='Login Page']")

        # Find element with text containing whitespace (use normalize-space)
        # YOUR CODE HERE
        pass

    def test_xpath_axes(self, driver):
        """
        Use XPath axes for relative element location.
        """
        # Following: Find element after username
        # YOUR CODE HERE

        # Preceding: Find element before password
        # YOUR CODE HERE

        # Parent: Find parent of username input
        # YOUR CODE HERE

        # Ancestor: Find form ancestor of button
        # YOUR CODE HERE
        pass