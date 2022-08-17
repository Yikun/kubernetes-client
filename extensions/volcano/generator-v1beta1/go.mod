module cmd/generate/generate.go

require (
	github.com/fabric8io/kubernetes-client/generator v0.0.0
	k8s.io/api v0.19.0 // indirect
	k8s.io/apimachinery v0.19.0
	volcano.sh/apis v1.6.0
)

replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

go 1.16
