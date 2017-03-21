package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.PhotoForm;
import com.wang.form.ShowForm;
import com.wang.form.ShowPhotoRelForm;

@Service
public class ShowServiceImpl implements ShowService{
	
LoginDao dao = null;
	
	@Override
	public List<ShowForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<ShowForm> show = LoginDao.SelectAllShow();	
		log.info("selectAllShowSuccess");
			return show;
	}
	
	
	@Override
	public String insertShow(ShowForm showForm){						
		String sucflg = LoginDao.AddT_show(showForm);						
		return sucflg;		
	};
	
	@Override
	public String insertPhoto(PhotoForm photoForm){						
		String ucfflg = LoginDao.AddT_photo(photoForm);						
		return ucfflg;		
	};
	
	@Override
	public String insertPhotoshowrel(ShowPhotoRelForm showPhotoRelForm){						
		String relflg = LoginDao.AddT_showphotorel(showPhotoRelForm);						
		return relflg;		
	};
	
	@Override
	public List<ShowPhotoRelForm> findrelbyid(long id){						
		List<ShowPhotoRelForm> rel = LoginDao.FindT_showphotorel(id);						
		return rel;		
	};
	
	@Override
	public List<PhotoForm> findphotonamebyid(long photo_id){						
		List<PhotoForm> photo = LoginDao.FindT_photonamebyid(photo_id);						
		return photo;		
	};
	
	


}
