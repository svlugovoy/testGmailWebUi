package com.svlugovoy.testgmailwebui.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by serhii.luhovyi on 6/16/2016.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory({Major.class})
public interface Major {
}
