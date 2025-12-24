"""
Multi-browser driver factory with webdriver-manager.

Supports:
- Chrome
- Firefox
- Edge
"""
import shutil
import subprocess
from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.edge.service import Service as EdgeService
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from webdriver_manager.microsoft import EdgeChromiumDriverManager


@contextmanager
def create_driver(browser: str = "chrome", headless: bool = False):
    """
    Create a WebDriver instance for the specified browser.

    Args:
        browser: Browser name ("chrome", "firefox", "edge")
        headless: Run in headless mode if True

    Yields:
        WebDriver instance

    Example:
        with create_driver("firefox", headless=True) as driver:
            driver.get("https://example.com")
    """
    driver = None

    try:
        if browser.lower() == "chrome":
            # TODO: Implement Chrome driver setup
            # 1. Create ChromeOptions
            chrome_options = webdriver.ChromeOptions()
            # 2. Add headless argument if needed
            if headless:
                chrome_options.add_argument("--headless")
            chrome_options.add_argument("--window-size=2560,1440")
            # 3. Use ChromeDriverManager for automatic driver download
            service = ChromeService(ChromeDriverManager().install())
            driver = webdriver.Chrome(service=service, options=chrome_options)

        elif browser.lower() == "firefox":
            # TODO: Implement Firefox driver setup
            # 1. Create FirefoxOptions
            firefox_options = webdriver.FirefoxOptions()
            # 2. Add headless argument if needed (note: Firefox uses -headless)
            if headless:
                firefox_options.add_argument("-headless")
            # 3. Use GeckoDriverManager
            firefox_options.add_argument("--window-size=2560,1440")
            service = FirefoxService(GeckoDriverManager().install())
            driver = webdriver.Firefox(service=service, options=firefox_options)

        elif browser.lower() == "edge":
            # TODO: Implement Edge driver setup
            # 1. Create EdgeOptions
            edge_options = webdriver.EdgeOptions()
            # 2. Add headless argument if needed
            if headless:
                edge_options.add_argument("--headless")
            # 3. Use EdgeChromiumDriverManager
            service = EdgeService(EdgeChromiumDriverManager().install())
            driver = webdriver.Edge(service=service, options=edge_options)

        else:
            raise ValueError(f"Unsupported browser: {browser}")

        driver.implicitly_wait(10)
        yield driver

    finally:
        if driver:
            driver.quit()


def get_browser_version(browser: str) -> str:
    """
    Get the installed browser version.

    TODO: Implement version detection for each browser
    """
    # YOUR CODE HERE
    browser = browser.lower()

    commands = {
        "chrome": ["google-chrome", "--version"],
        "firefox": ["firefox", "--version"],
        "edge": ["msedge", "--version"]
    }

    if browser not in commands:
        raise ValueError(f"Unsupported browser: {browser}")

    executable = shutil.which(commands[browser][0])
    if not executable:
        raise RuntimeError(f"Browser executable not found: {commands[browser][0]}")
    result = subprocess.run(commands[browser], capture_output=True, text=True)
    return result.stdout.strip()
