SUMMARY = "Qualcomm AudioReach kernel module"
DESCRIPTION = "This module is designed for integration with the AudioReach framework, \
allowing flexible deployment of audio algorithms and efficient hardware utilization."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a5a2ad232bafb6974f9a29d1ba0f488"

SRC_URI = "git://github.com/AudioReach/audioreach-kernel.git;protocol=https;branch=master \
           file://audioreach.rules \
           file://asoc-blacklist.conf \
    "
SRCREV = "c9aaca948f549c801020724553077242ce77c66a"

PV = "0.0+git"

inherit module

MAKE_TARGETS = "modules"

MODULES_MODULE_SYMVERS_LOCATION = "audioreach-driver"

do_install:append() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/audioreach.rules ${D}${sysconfdir}/udev/rules.d/
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${UNPACKDIR}/asoc-blacklist.conf ${D}${sysconfdir}/modprobe.d/
}

FILES:${PN} += "${sysconfdir}/udev/rules.d/audioreach.rules"
FILES:${PN} += "${sysconfdir}/modprobe.d/asoc-blacklist.conf"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
