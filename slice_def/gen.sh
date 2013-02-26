rm -rf generated
mkdir generated
/opt/Ice-3.3.1/bin/slice2java -Islice --output-dir generated --list-generated slice/*.ice
