/*ERR02-J. Prevent exceptions while logging data*/

/*NonCompliant Code Example */
try {
    // ...
  } catch (SecurityException se) {
    System.err.println(se);
    // Recover from exception
  }

/*Compliant Code Exampel */
try {
    // ...
  } catch(SecurityException se) {
    logger.log(Level.SEVERE, se);
    // Recover from exception
  }