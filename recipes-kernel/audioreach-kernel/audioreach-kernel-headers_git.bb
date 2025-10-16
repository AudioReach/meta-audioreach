DESCRIPTION = "AudioReach kernel header"
HOMEPAGE = "https://github.com/Audioreach/audioreach-kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a5a2ad232bafb6974f9a29d1ba0f488"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://github.com/Audioreach/audioreach-kernel.git;protocol=https;branch=master"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install:append() {
    install -d ${D}${includedir}/linux
    cp -fr ${S}/include/uapi/linux/* ${D}${includedir}/linux
}

ALLOW_EMPTY:${PN} = "1"
