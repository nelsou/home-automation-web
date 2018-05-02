#!/usr/bin/python
import RPi.GPIO as GPIO
import time
import sys

GPIO.setmode(GPIO.BCM)

validPins = [1, 2,  3,  4,  5,  6,  9, 10, 11, 13, 17, 19, 22, 26, 27]

if len(sys.argv) == 0:
    print " Missing argument: pin"
    sys.exit()
elif pin not in validPins:
    print " pin is invalid. Not in the validPins list"
    sys.exit()

pin = sys.argv[0]
sleepTime = 0.2

try:
    GPIO.setup(pin, GPIO.OUT)
    GPIO.output(pin, GPIO.HIGH)
    time.sleep(sleepTime)
    GPIO.output(pin, GPIO.LOW)

# End program cleanly with keyboard
except KeyboardInterrupt:
    print "  Ctrl+C caught"

finally:
    # Reset GPIO settings
    GPIO.cleanup()
    print "  Exit"