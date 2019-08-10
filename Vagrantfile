VAGRANTFILE_API_VERSION = "2"

unless Vagrant.has_plugin?("vagrant-disksize")
  puts 'Installing vagrant-disksize Plugin...'
  system('vagrant plugin install vagrant-disksize')
end

unless Vagrant.has_plugin?("vagrant-vbguest")
  puts 'Installing vagrant-vbguest Plugin...'
  system('vagrant plugin install vagrant-vbguest')
end

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.define "ubuntudev" , primary: true do |ubuntudev|
  ubuntudev.vm.box = "ubuntu/bionic64"
  ubuntudev.vm.hostname = "ubuntudev"
  ubuntudev.disksize.size = '75GB'
  ubuntudev.vbguest.auto_update = true
  
  ubuntudev.vm.provider :virtualbox do |vb|
	  vb.default_nic_type = "Am79C973"
	  vb.customize ["modifyvm"     , :id, "--memory", "16384"]
      vb.customize ["modifyvm"     , :id, "--name"  , "GraalVM workshop"]
      vb.customize ["modifyvm"     , :id, "--cpus"  , 6]
	  vb.customize ["modifyvm"     , :id, "--clipboard","bidirectional"]
	  vb.customize ["modifyvm"     , :id, "--vram","16"]
  end
	
  #this starts provisioning the machine
  ubuntudev.vm.provision :shell, path: "provision.sh"
  end
end
