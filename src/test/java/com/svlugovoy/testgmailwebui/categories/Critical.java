package com.svlugovoy.testgmailwebui.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 27.05.2016.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {
}
