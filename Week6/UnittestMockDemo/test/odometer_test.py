from unittest import TestCase
from unittest.mock import Mock
from src import odometer

class TestOdometer(TestCase):
    def test_odometer(self):
        odometer.speed = Mock()
        odometer.speed.return_value = 70

        self.assertFalse(odometer.alert())

    def test_alert_slow(self):
        odometer.speed = Mock()
        odometer.speed.return_value = 59
        self.assertTrue(odometer.alert())

    def test_alert_fast(self):
        odometer.speed = Mock()
        odometer.speed.return_value = 130
        self.assertTrue(odometer.alert())
