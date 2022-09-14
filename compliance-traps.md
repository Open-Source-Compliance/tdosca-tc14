# Compliance Traps of TDOSCA-TC14-PLAINHW

* This app uses internal classes licensed under different licenses:
  - Default License: M.I.T
  - Main.java :-
    - licensed under the M.I.T
    - only a licensing statement in the file header
    - NO SPDX identifier
  - Greeter.java :-
    - licensed under the A.p.a.c.h.e-2.0
    - license text is LICENSE.A.p.a.c.h.e-2.0 on the top level
    - file contains a licensing statement without SPDX identifier
  - GreeterTest.java :- A.p.a.c.h.e-2.0 (see SPDX id in file header)
  - Tipster.java :- B.S.D-3-Clause (see License text in the header)
  - TipsterTest.java :- B.S.D-3-Clause (no license text, but an SPDX tag)

* On the toplevel the App delivers two license files which must not be confound by the scanning tools
  - named LICENSE (M.I.T = Default License)
  - named LICENSE.A.p.a.c.h.e-2.0 (= valid for Greeter)

* The file LICENSE contains the text of the MIT license but does not explicitly declare that the content is the text of the MIT license

**To sum it up**: *Here we have an irritating overall situation. There is a master license (M.I.T) but only one file (main) falls under it. And there is a 'competing' main license (Apache), which is not a main license, just the license text for one of the files.*

* On the top level, the source repo (= input-sources) offers a NOTICE.md file valid for Greeter

* Additionally the software depends on the external 3rd party components
  * apache-log4j:
    - repository: https://logging.apache.org/log4j/2.x/download.html
    - license: Apache-2.0
    - NOTICE.txt: yes
  * joda-time
    - repository: https://github.com/JodaOrg/joda-time/releases
    - license: Apache-2.0
    - NOTICE.txt: yes

This 3rd Party software is integrated into the zip package created by ``mvn package``. Particularly the pom.xml does NOT declared these dependencies as *provided* etc. Hence, the scanning tools must find the respective compliance artifacts.

*Elucidation*:

* If one focuses on the upload of the repository content (sources and maven files), then one does not additionally distribute the 3rd party components. Hence, the repository on its own must only contain the compliance artifacts valid for the uploaded sources.
* But if one considers the fact, that in this case ``mvn package`` also creates a distributable zip file  containing the TC14-jar file, the 3rd-Party-jar files, and a start script (added by the maven plugin *assembly*), then it is clear, that this distributable zip file should also contain the compliance artifacts of the 3rd party components:
  - Hence the tested scanning tools should also deliver the compliance artifacts of these 3rd party tools
  - For the moment, this is not implemented

