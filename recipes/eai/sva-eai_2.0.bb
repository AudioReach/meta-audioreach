SUMMARY = "SVA-EAI"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = ""

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/eai"

inherit autotools pkgconfig

do_install() {
    oe_runmake DESTDIR=${D} install

    # Also ensure headers go to expected location
    install -d ${D}${includedir}/sva-eai
    install -m 0644 ${S}/runtime/api/eai.h            ${D}${includedir}/sva-eai/
    install -m 0644 ${S}/runtime/api/eai_training.h   ${D}${includedir}/sva-eai/
    install -m 0644 ${S}/runtime/api/eai_version.h    ${D}${includedir}/sva-eai/
    install -m 0644 ${S}/runtime/api/eai_event_intf.h ${D}${includedir}/sva-eai/
}

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"