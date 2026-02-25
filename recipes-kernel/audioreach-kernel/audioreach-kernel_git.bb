SUMMARY = "Qualcomm AudioReach kernel module"
DESCRIPTION = "This module is designed for integration with the AudioReach framework, \
allowing flexible deployment of audio algorithms and efficient hardware utilization."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d683615f65309f6c050cbd1bb2b3c575"

SRC_URI = "git://github.com/AudioReach/audioreach-kernel.git;protocol=https;branch=master \
           file://audioreach.rules \
           file://asoc-blacklist.conf \
           file://v1-0001-audioreach-driver-audioreach-common-Fix-WSA-Mute-.patch \
    "
SRCREV = "2d26f557e1ccc3e5e9bea0b843671805b3fe8d5e"

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
