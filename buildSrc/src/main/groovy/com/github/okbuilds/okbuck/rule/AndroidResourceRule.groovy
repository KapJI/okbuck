/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Piasy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.okbuilds.okbuck.rule

import org.apache.commons.lang.StringUtils

import static com.github.okbuilds.core.util.CheckUtil.checkStringNotEmpty

/**
 * android_resource()
 * */
final class AndroidResourceRule extends BuckRule {

    private final String mRes
    private final String mPackage
    private final String mAssets

    AndroidResourceRule(String name, List<String> visibility, List<String> deps, String packageName,
                        String res, String assets) {
        super("android_resource", name, visibility, deps)
        mRes = res
        checkStringNotEmpty(packageName, "AndroidResourceRule package can't be empty.")
        mPackage = packageName
        mAssets = assets
    }

    @Override
    protected final void printContent(PrintStream printer) {
        if (!StringUtils.isEmpty(mRes)) {
            printer.println("\tres = '${mRes}',")
        }
        printer.println("\tpackage = '${mPackage}',")
        if (!StringUtils.isEmpty(mAssets)) {
            printer.println("\tassets = '${mAssets}',")
        }
        printer.println("\tresource_union = True,")
    }
}