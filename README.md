# ECDSA-Verifier
A Java application for Elliptic Curve Digital signature verification

Related to Elliptic curve crypotography or RSA cryptography. The ECDSA Verifier requires two JSON files (Signed Signature Json data file and Curve parameters Json data file). These JSON files can be generated in the ECDSA Generator [which can be downloaded below] before using the ECDSA Verifier. This algorithm verify a ECDSA signature by taking it as input to decode the proof number s from the digital signature and recover a  original point through the elliptic curve using the public key. Then validate the signature by comparing the x coordinate of the recovered original point with the r value of the digital signature which is previously generated randomly during the signing process (ECDSA Generation). In addition, the algorithm also detect for the similarity of r values among the all the digital signatures to crack for the private key (Just like the incident of the Sony PS3 homebrew).

## Getting Started
1. Download the application
2. Select input JSON file of the signed digital signatures data (can be generated from ECDSA generator)
3. Select input JSON file of the curve parameters data (can be generated from ECDSA generator)
4. Execute for the verification result
