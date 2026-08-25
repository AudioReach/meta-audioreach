SUMMARY = "CAPIv2 API Headers"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/mm-audio-headers/capiv2_api"

inherit autotools pkgconfig

do_compile[noexec] = "1"

FILES:${PN}-dev = "${includedir}/* ${libdir}/pkgconfig/*"
FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"