#!/usr/bin/python
import RPi.GPIO as GPIO
import sys

GPIO.setmode(GPIO.BCM)

validPins = [7, 8, 12, 14, 15, 16, 18, 20, 21, 23, 24, 25]

if len(sys.argv) == 0:
    print " Missing argument: pin"
    sys.exit()
elif pin not in validPins:
    print " pin is invalid. Not in the validPins list"
    sys.exit()

pin = sys.argv[0]

try:
    GPIO.setup(pin, GPIO.IN)
    print GPIO.input(pin)

# End program cleanly with keyboard
except KeyboardInterrupt:
    print "  Ctrl+C caught"

finally:
    # Reset GPIO settings
    GPIO.cleanup()
    print "  Exit"