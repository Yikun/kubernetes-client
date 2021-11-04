declare -a modules=("generator")

for module in ${modules[*]}
do
    echo "Compiling ${module}"
    cd $module
    make
    cd ..
done
