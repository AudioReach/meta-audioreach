inherit module

SUMMARY = "Qualcomm AudioReach kernel module"
DESCRIPTION = "This module is designed for integration with the AudioReach framework, \
allowing flexible deployment of audio algorithms and efficient hardware utilization."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a5a2ad232bafb6974f9a29d1ba0f488"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/audioreach-kernel.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

MAKE_TARGETS = "modules"

MODULES_MODULE_SYMVERS_LOCATION = "audioreach-driver"

EXTRA_OEMAKE:append:qcom += "VENDOR_QCOM=1"

do_install:append() {
    install -d ${D}${includedir}/linux
    cp -fr ${S}/include/uapi/linux/* ${D}${includedir}/linux
}

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
