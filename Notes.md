# Junit notes

## Steps to define a test

- Setup all conditions needed for testing (create any required
objects, allocate any needed resources, etc.)
- Call the method to be tested
- Verify that the method to be tested functioned as expected
- Clean up after itself

## Assertion types

- assertEquals

'''
assertEquals([String message],
        expected,
        actual)
'''

-- floting point

'''
assertEquals([String message],
        expected,
        actual,
    tolerance)
'''

- assertNull

'''
assertNull([String message], java.lang.Object object)
assertNotNull([String message], java.lang.Object object)
'''

- assertSame

'''
assertSame([String message], expected, actual)
assertNotSame([String message], expected, actual)
'''

- assertTrue

'''
assertTrue([String message], boolean condition)
assertFalse([String message], boolean condition)
'''

- fail

'''
fail([String message])
'''

## RIGHT -BICEP

- Right - Are the results right?
- B -- Are all the boundary conditions CORRECT?
- I -- Can you check inverse relationships?
- C -- Can you cross-check results using other means?
- E -- Can you force error conditions to happen?
- P -- Are performance characteristics within bounds?
