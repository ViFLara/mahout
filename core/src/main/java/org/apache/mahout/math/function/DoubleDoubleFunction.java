/*
Copyright 1999 CERN - European Organization for Nuclear Research.
Permission to use, copy, modify, distribute and sell this software and its documentation for any purpose
is hereby granted without fee, provided that the above copyright notice appear in all copies and
that both that copyright notice and this permission notice appear in supporting documentation.
CERN makes no representations about the suitability of this software for any purpose.
It is provided "as is" without expressed or implied warranty.
*/

package org.apache.mahout.math.function;

/**
 * Interface that represents a function object: a function that takes two arguments and returns a single value.
 **/
public abstract class DoubleDoubleFunction {

  /**
   * Apply the function to the arguments and return the result
   *
   * @param arg1 a double for the first argument
   * @param arg2 a double for the second argument
   * @return the result of applying the function
   */
  public abstract double apply(double arg1, double arg2);

  /**
   * @return true iff f(x, 0) = x for any x
   */
  public boolean isLikeRightPlus() {
    return false;
  }

  /**
   * @return true iff f(0, y) = 0 for any y
   */
  public boolean isLikeLeftMult() {
    return false;
  }

  /**
   * @return true iff f(x, 0) = 0 for any x
   */
  public boolean isLikeRightMult() {
    return false;
  }

  /**
   * @return true iff f(x, 0) = f(0, y) = 0 for any x, y
   */
  public boolean isLikeMult() {
    return isLikeLeftMult() && isLikeRightMult();
  }

  /**
   * @return true iff f(x, y) = f(y, x) for any x, y
   */
  public boolean isCommutative() {
    return false;
  }

  /**
   * @return true iff f(x, f(y, z)) = f(f(x, y), z) for any x, y, z
   */
  public boolean isAssociative() {
    return false;
  }

  /**
   * @return true iff f(x, y) = f(y, x) for any x, y AND f(x, f(y, z)) = f(f(x, y), z) for any x, y, z
   */
  public boolean isAssociativeAndCommutative() {
    return isAssociative() && isCommutative();
  }

  /**
   * @return true iff f(0, 0) != 0
   */
  public boolean isDensifying() {
    return apply(0.0, 0.0) != 0.0;
  }
}
