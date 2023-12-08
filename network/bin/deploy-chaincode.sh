./package_chaincode.sh "./../../maskedfl" "maskedfl" $1
./install_chaincode.sh "./../../maskedfl" "maskedfl" $1
./approve_chaincode.sh "./../../maskedfl" "maskedfl" $1
./commit_chaincode.sh "./../../maskedfl" "maskedfl" $1


echo "===================== Invoking Init ====================="
# ./invoke_init.sh fabcar $1