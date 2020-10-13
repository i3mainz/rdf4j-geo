#connect "http://localhost:8080/rdf4j-server".
show repositories.
create native.
rsetools
rsetoolsstore
10000
spoc

open rsetools.
load "/opt/testdata.owl".
close.
quit.
