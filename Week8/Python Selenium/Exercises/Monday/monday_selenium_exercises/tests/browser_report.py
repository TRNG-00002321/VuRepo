"""
Browser capability reporter.

Displays information about installed browsers and their capabilities.
"""

from monday_selenium_exercises.utils.multi_browser_factory import create_driver


def generate_browser_report():
    """Generate a report of browser capabilities."""
    browsers = ["chrome", "firefox"]

    print("=" * 60)
    print("BROWSER CAPABILITY REPORT")
    print("=" * 60)

    for browser in browsers:
        print(f"\n{browser.upper()}")
        print("-" * 40)

        try:
            with create_driver(browser, headless=True) as driver:
                # TODO: Print browser capabilities
                # - driver.capabilities.get('browserName')
                print(driver.capabilities.get('browserName'))
                # - driver.capabilities.get('browserVersion')
                print(driver.capabilities.get('browserVersion'))
                # - driver.capabilities.get('platformName')
                print(driver.capabilities.get('platformName'))

        except Exception as e:
            print(f"  ❌ Not available: {e}")


if __name__ == "__main__":
    generate_browser_report()