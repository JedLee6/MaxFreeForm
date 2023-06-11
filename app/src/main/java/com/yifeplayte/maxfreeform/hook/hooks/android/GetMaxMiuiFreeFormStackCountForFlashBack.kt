package com.yifeplayte.maxfreeform.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.yifeplayte.maxfreeform.hook.hooks.BaseHook

object GetMaxMiuiFreeFormStackCountForFlashBack : BaseHook() {
    override fun init() {
        loadClass("com.android.server.wm.MiuiFreeFormStackDisplayStrategy").methodFinder()
            .filterByName("getMaxMiuiFreeFormStackCountForFlashBack").first().createHook {
                returnConstant(256)
            }
    }
}
