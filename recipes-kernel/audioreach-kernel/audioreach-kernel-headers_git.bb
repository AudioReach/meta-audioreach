DESCRIPTION = "AudioReach kernel header"
HOMEPAGE = "https://github.com/AudioReach/audioreach-kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d683615f65309f6c050cbd1bb2b3c575"

SRCREV = "2d26f557e1ccc3e5e9bea0b843671805b3fe8d5e"
PV = "0.0+git"
SRC_URI = "git://github.com/AudioReach/audioreach-kernel.git;protocol=https;branch=master"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install:append() {
    install -d ${D}${includedir}/linux
    cp -fr ${S}/include/uapi/linux/* ${D}${includedir}/linux
}

ALLOW_EMPTY:${PN} = "1"
