SUMMARY = "AudioReach Package Group"

LICENSE = "BSD-3-Clause"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    audioreach-conf \
    audioreach-graphmgr \
    audioreach-graphservices \
    tinyalsa \
"
RDEPENDS:${PN}:append:raspberrypi4 = " \
    audioreach-engine \
"
RDEPENDS:${PN}:append:qcom = " \
    audioreach-audio-utils \
    audioreach-pal-headers \
    audioreach-pal \
    audioreach-pipewire-plugin \
    audioreach-kernel-headers \
    audioreach-kernel \
    tinycompress \
"
