"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from monday_selenium_exercises.utils.driver_factory import create_chrome_driver

def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")
        assert driver.title == "The Internet"

def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")
        assert "Welcome to" in driver.find_element(By.TAG_NAME, "h1").text

def test_links_present():
    """Verify that all example links are present on the page."""
    with create_chrome_driver() as driver:
        # Navigate to the website FIRST
        driver.get("https://the-internet.herokuapp.com/")
        
        # Use find_elements to get all links
        links = driver.find_elements(By.TAG_NAME, "a")
        
        # Use list comprehension to extract link texts
        link_texts = [link.text for link in links]
        
        assert "Sortable Data Tables" in link_texts
        assert "Dynamic Controls" in link_texts

def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")
        link = driver.find_element(By.LINK_TEXT, "Dynamic Content")
        assert "/dynamic_content" in link.get_attribute("href")
