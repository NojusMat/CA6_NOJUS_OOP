package org.example.Filters;

/**
 * This interface defines a method named matches(), and we can add classes that implement this
 * interface and override matches() to match objects based on specific fields.
 *
 * @author Dermot Logue- DkIT
 * Reference Link: https://github.com/logued/oop-ifilter-sample
 *
 */


public interface IFilter
{

    boolean matches(Object other);

}

