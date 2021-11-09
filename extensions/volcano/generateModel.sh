declare -a modules=("generator-v1beta1")

for module in ${modules[*]}
do
    echo "Compiling ${module}"
    cd $module
    make
    cd ..
done
