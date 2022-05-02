package com.yifeplayte.maxfreeform.hook.home

import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookMethod
import com.yifeplayte.maxfreeform.hook.BaseHook
import de.robv.android.xposed.XposedBridge

object CanTaskEnterSmallWindow : BaseHook() {
    override fun init() {
        try {
            findMethod("com.miui.home.launcher.RecentsAndFSGestureUtils") {
                name == "canTaskEnterSmallWindow"
            }.hookMethod {
                after { param ->
                    param.result = true
                }
            }
            XposedBridge.log("MaxFreeForm: Hook canTaskEnterSmallWindow success!")
        } catch (e: Throwable) {
            XposedBridge.log("MaxFreeForm: Hook canTaskEnterSmallWindow failed!")
        }
    }
}