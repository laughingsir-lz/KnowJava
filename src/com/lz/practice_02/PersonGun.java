package com.lz.practice_02;

/**
 * PersonGun类
 */
public class PersonGun {
    Gun gun = new Gun();
    /**
     * 射击方法
     */
    public void shoot() {
        for (int i = 0; i < 3; i++) {
            if (gun.clip[0] == 0) {
                gun.push();
                gun.pop();
            }
        }
    }
}
