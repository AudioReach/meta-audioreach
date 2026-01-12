DESCRIPTION = "AudioReach kernel header"
HOMEPAGE = "https://github.com/AudioReach/audioreach-kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a5a2ad232bafb6974f9a29d1ba0f488"

SRCREV = "c69bda5d77c2540662763d2c7fb6365f2ab0efb7"
PV = "0.0+git"
SRC_URI = "git://github.com/AudioReach/audioreach-kernel.git;protocol=https;branch=master"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install:append() {
    install -d ${D}${includedir}/linux
    cp -fr ${S}/include/uapi/linux/* ${D}${includedir}/linux
}

ALLOW_EMPTY:${PN} = "1"
