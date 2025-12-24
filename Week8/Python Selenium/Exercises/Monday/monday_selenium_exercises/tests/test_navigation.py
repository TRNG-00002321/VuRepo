"""
Test navigation functionality using Python Selenium.

Implement tests that:
1. Navigate to https://the-internet.herokuapp.com/
2. Click on "Form Authentication" link
3. Verify URL changed to /login
4. Use back/forward navigation
5. Capture screenshots at key points
"""


import pytest
import os
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from monday_selenium_exercises.utils.driver_factory import create_chrome_driver


def test_navigate_home_to_login():
    """
    Test: Navigate from home to login page

    Steps:
    1. Go to the-internet homepage
    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    with create_chrome_driver() as driver:
        # Step 1: Go to the-internet homepage
        driver.get("https://the-internet.herokuapp.com/")
        
        # Step 2: Find and click "Form Authentication" link
        form_auth_link = WebDriverWait(driver, 10).until(
            EC.element_to_be_clickable((By.LINK_TEXT, "Form Authentication"))
        )
        form_auth_link.click()
        
        # Step 3: Assert URL contains "/login"
        assert "/login" in driver.current_url, f"Expected '/login' in URL, got {driver.current_url}"
        
        # Step 4: Assert page contains "Login Page" heading
        login_heading = WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.TAG_NAME, "h2"))
        )
        assert "Login Page" in login_heading.text, f"Expected 'Login Page' heading, got {login_heading.text}"


def test_back_forward_navigation():
    """
    Test: Browser navigation (back/forward)

    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")
        driver.find_element(By.LINK_TEXT, "Sortable Data Tables").click()
        driver.back()
        assert driver.current_url == "https://the-internet.herokuapp.com/"
        driver.forward()
        assert driver.current_url == "https://the-internet.herokuapp.com/tables"


def test_capture_screenshot():
    """
    Test: Screenshot capture

    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE
    os.makedirs("screenshots", exist_ok=True)

    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")
        driver.save_screenshot("screenshots/homepage.png")

