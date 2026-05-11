FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:qcom = " \
    file://0001-Add-AudioReach-device-labels-for-pipewire-stack.patch \
"
