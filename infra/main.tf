provider "aws" {
  region = "us-east-1"
}

data "aws_ami" "existing_ami" {
  owners = ["self"]
  filter {
    name   = "image-id"
    values = ["ami-0865cda3ee8358d58"]
  }
}

resource "aws_instance" "example" {
  ami           = data.aws_ami.existing_ami.id # Imagem de instancia com app em spring boot
  instance_type = "t2.micro"
  associate_public_ip_address = true
  vpc_security_group_ids = [aws_security_group.allow_8080.id]

  tags = {
    Name = "terraform-const-soft-grupoB"
  }
}

# Check if the security group already exists
data "aws_security_group" "existing_sg" {
  name = "allow_8080"
  
  # This prevents Terraform from erroring if the security group doesn't exist
  count = 0
}

resource "aws_security_group" "allow_8080" {
  name        = "allow_8080"
  description = "Allow TCP 8080 inbound traffic"

  ingress {
    description = "TCP 8080 from anywhere"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "allow_8080"
  }
  lifecycle {
    create_before_destroy = true
    ignore_changes = [name]
  }
}