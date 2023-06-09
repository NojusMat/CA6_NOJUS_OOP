package org.example.Filters;

import org.example.DTOs.Player;

/**
 * This interface defines a method named matches(), and we can add classes that implement this
 * interface and override matches() to match objects based on specific fields.
 *
 * @author Dermot Logue- DkIT
 * Reference Link: https://github.com/logued/oop-ifilter-sample
 *
 */


public interface IFilter  // filter interface
{

    boolean matches(Object other);

    boolean matches(Player player);

}

