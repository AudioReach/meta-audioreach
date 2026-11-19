# SPDX-License-Identifier: MIT

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-qcom-6.18:"

# kernel-topics: dt-bindings + DTS patches (PRs #2155, #2156, #2159)
SRC_URI += " \
    file://0001-ASoC-qcom-q6dsp-lpass-clocks-fix-off-by-one-in-clks-.patch \
"
